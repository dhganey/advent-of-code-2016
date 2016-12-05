def triangleValid(part1, part2, part3):
    side1 = int(part1)
    side2 = int(part2)
    side3 = int(part3)
    return (side1 + side2 > side3 and
            side2 + side3 > side1 and
            side3 + side1 > side2)

# part 1
with open('input.txt') as f:
    content = f.readlines()
    possibleTriangles = 0
    for triangle in content:
        parts = triangle.split();

        if triangleValid(parts[0], parts[1], parts[2]):
            possibleTriangles = possibleTriangles + 1
    print(possibleTriangles)

#part 2
with open('input.txt') as f:
    content = f.readlines()
    possibleTriangles = 0
    pointer = 0
    for pointer in range(0, len(content), 3):
        row1 = content[pointer].split()
        row2 = content[pointer + 1].split()
        row3 = content[pointer + 2].split()
 
        for i in range(0, 3):
            if triangleValid(row1[i], row2[i], row3[i]):
                possibleTriangles = possibleTriangles + 1

    print(possibleTriangles)
