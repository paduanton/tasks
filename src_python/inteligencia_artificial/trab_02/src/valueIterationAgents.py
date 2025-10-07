import util
import random
from learningAgents import ValueEstimationAgent

class ValueIterationAgent(ValueEstimationAgent):
    def __init__(self, mdp, discount=0.9, iterations=100):
        self.mdp = mdp
        self.discount = discount
        self.iterations = iterations
        self.values = util.Counter()  # V(s) default 0

        for _ in range(iterations):
            newValues = util.Counter()
            for s in mdp.getStates():
                if self.mdp.isTerminal(s):
                    newValues[s] = 0.0
                    continue
                actions = self.mdp.getPossibleActions(s)
                if not actions:
                    newValues[s] = 0.0
                    continue
                qvals = [self.computeQValueFromValues(s, a) for a in actions]
                newValues[s] = max(qvals)
            self.values = newValues

    def getValue(self, state):
        return self.values[state]

    def computeQValueFromValues(self, state, action):
        q = 0.0
        for nextState, prob in self.mdp.getTransitionStatesAndProbs(state, action):
            reward = self.mdp.getReward(state, action, nextState)
            q += prob * (reward + self.discount * self.values[nextState])
        return q

    def computeActionFromValues(self, state):
        if self.mdp.isTerminal(state):
            return None
        actions = self.mdp.getPossibleActions(state)
        if not actions:
            return None

        bestVal = None
        bestActs = []
        for a in actions:
            q = self.computeQValueFromValues(state, a)
            if (bestVal is None) or (q > bestVal):
                bestVal = q
                bestActs = [a]
            elif q == bestVal:
                bestActs.append(a)

        return random.choice(bestActs)


    def getPolicy(self, state):
        return self.computeActionFromValues(state)

    def getAction(self, state):
        return self.computeActionFromValues(state)

    def getQValue(self, state, action):
        return self.computeQValueFromValues(state, action)
