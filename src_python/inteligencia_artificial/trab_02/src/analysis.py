def question2():
    answerDiscount = 0.9
    answerNoise = 0.01
    return answerDiscount, answerNoise

if __name__ == '__main__':
    print('Answers to analysis questions:')
    import analysis
    for q in [q for q in dir(analysis) if q.startswith('question')]:
        response = getattr(analysis, q)()
        print('  Question %s:\t%s' % (q, str(response)))
