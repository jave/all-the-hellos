def latest(scores):
    return scores[len(scores)-1]


def personal_best(scores):
    return latest(sorted(scores))


def personal_top_three(scores):
    return sorted(scores, reverse=True)[0:3]
