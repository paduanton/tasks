from learningAgents import ReinforcementAgent
from featureExtractors import IdentityExtractor, CoordinateExtractor
import random, util

class QLearningAgent(ReinforcementAgent):
    def __init__(self, **args):
        ReinforcementAgent.__init__(self, **args)
        self.qvalues = util.Counter()

    def getQValue(self, state, action):
        return self.qvalues[(state, action)]

    def computeValueFromQValues(self, state):
        legal = self.getLegalActions(state)
        if not legal:
            return 0.0
        return max(self.getQValue(state, a) for a in legal)

    def computeActionFromQValues(self, state):
        legal = self.getLegalActions(state)
        if not legal:
            return None
        bestVal = self.computeValueFromQValues(state)
        bestActs = [a for a in legal if self.getQValue(state, a) == bestVal]
        return random.choice(bestActs)

    def getAction(self, state):
        legal = self.getLegalActions(state)
        if not legal:
            return None
        if util.flipCoin(self.epsilon):
            action = random.choice(legal)
        else:
            action = self.computeActionFromQValues(state)
        self.doAction(state, action)
        return action

    def update(self, state, action, nextState, reward):
        oldQ = self.getQValue(state, action)
        nextV = self.computeValueFromQValues(nextState)
        target = reward + self.discount * nextV
        newQ = (1 - self.alpha) * oldQ + self.alpha * target
        self.qvalues[(state, action)] = newQ

class PacmanQAgent(QLearningAgent):
    def __init__(self, epsilon=0.05, gamma=0.8, alpha=0.2, numTraining=0, **args):
        args['epsilon'] = epsilon
        args['gamma'] = gamma
        args['alpha'] = alpha
        args['numTraining'] = numTraining
        QLearningAgent.__init__(self, **args)

    def getAction(self, state):
        action = QLearningAgent.getAction(self, state)
        self.doAction(state, action)
        return action

class ApproximateQAgent(QLearningAgent):
    def __init__(self, extractor='IdentityExtractor', **args):
        QLearningAgent.__init__(self, **args)
        self.featExtractor = util.lookup(extractor, globals())()
        self.weights = util.Counter()

    def getQValue(self, state, action):
        features = self.featExtractor.getFeatures(state, action)
        return sum(self.weights[f] * v for f, v in features.items())

    def update(self, state, action, nextState, reward):
        features = self.featExtractor.getFeatures(state, action)
        prediction = self.getQValue(state, action)
        target = reward + self.discount * self.computeValueFromQValues(nextState)
        delta = target - prediction

        for f, v in features.items():
            self.weights[f] += self.alpha * delta * v

    def final(self, state):
        QLearningAgent.final(self, state)

    def getWeights(self):
        return self.weights
