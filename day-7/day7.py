def isSegmentABBA(segment):
    for i in range(0, (len(segment) - 4 + 1)):
        window = segment[i:i+4]
        if window[0] == window[3] and window[1] == window[2] and window[0] != window [1]:
            return True
    return False

def getPossibleABAsOrBABs(segment):
    babs = []
    for i in range(0, len(segment) - 3 + 1):
        window = segment[i:i+3]
        if window[0] == window[2] and window[0] != window[1]:
            babs.append(window)
    return babs

def generateBab(aba): # "aba" returns "bab"
    return aba[1] + aba[0] + aba[1]

def lineSupportsSSL(abas, babs):
    for aba in abas:
        if generateBab(aba) in babs:
            return True

with open('input.txt') as f:
    content = f.readlines()
    validTLSAddresses = 0
    validSSLAddresses = 0

    for line in content:
        lineSupportsTLS = False
        lineSupportsTLSOverride = False
        segments = line.replace(']', '[').split('[')
        babs = []
        abas = []
        for i in range(0, len(segments)):
            currentSegment = segments[i]
            isBracketSection = (i % 2 != 0)
            if isSegmentABBA(currentSegment):
                if isBracketSection:
                    lineSupportsTLS = False
                    lineSupportsTLSOverride = True
                elif not lineSupportsTLSOverride:
                    lineSupportsTLS = True

            possibleABAsOrBABs = getPossibleABAsOrBABs(currentSegment)
            if isBracketSection:
                babs = babs + possibleABAsOrBABs
            else:
                abas = abas + possibleABAsOrBABs
        if lineSupportsTLS:
            validTLSAddresses = validTLSAddresses + 1
        if lineSupportsSSL(abas, babs):
            validSSLAddresses = validSSLAddresses + 1
    print validTLSAddresses
    print validSSLAddresses