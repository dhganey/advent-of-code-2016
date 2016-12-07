def isSegmentABBA(segment):
    for i in range(0, (len(segment) - 4 + 1)):
        window = segment[i:i+4]
        if window[0] == window[3] and window[1] == window[2] and window[0] != window [1]:
            return True
    return False

with open('input.txt') as f:
    content = f.readlines()
    validAddresses = 0

    for line in content:
        lineGood = False
        segments = line.replace(']', '[').split('[')
        for i in range(0, len(segments)):
            currentSegment = segments[i]
            isBracketSection = (i % 2 != 0)
            if isSegmentABBA(currentSegment):
                if isBracketSection:
                    lineGood = False
                    break
                else:
                    lineGood = True
        if lineGood:
            validAddresses = validAddresses + 1
    print validAddresses