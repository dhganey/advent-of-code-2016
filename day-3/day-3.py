with open('input.txt') as f:
    content = f.readlines()
    possibleTriangles = 0
    for triangle in content:
        parts = triangle.split();
        side1 = int(parts[0])
        side2 = int(parts[1])
        side3 = int(parts[2])

        if (side1 + side2 > side3 and
            side2 + side3 > side1 and
            side3 + side1 > side2):
            possibleTriangles = possibleTriangles + 1
    print(possibleTriangles)