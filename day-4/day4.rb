def get_expected_checksum(line)
    sortedLine = line.downcase.tr('-', '').chars.sort

    first = sortedLine.map { |c| [c, sortedLine.count(c)] }.max_by(&:last)[0]
    sortedLine.reject! {|x| x.eql? first}
    second = sortedLine.map { |c| [c, sortedLine.count(c)] }.max_by(&:last)[0]
    sortedLine.reject! {|x| x.eql? second}
    third = sortedLine.map { |c| [c, sortedLine.count(c)] }.max_by(&:last)[0]
    sortedLine.reject! {|x| x.eql? third}
    fourth = sortedLine.map { |c| [c, sortedLine.count(c)] }.max_by(&:last)[0]
    sortedLine.reject! {|x| x.eql? fourth}
    fifth = sortedLine.map { |c| [c, sortedLine.count(c)] }.max_by(&:last)[0]

    return first + second + third + fourth + fifth
end

def validate_room(room)
    match = room.match(/(.*)-(\d*)\[(.*)\]/)
    line_name = match[1]
    sector_id = match[2]
    checksum = match[3]
    expected_checksum = get_expected_checksum(line_name)
    if checksum.eql? expected_checksum
        return sector_id
    end
    return 0
end

def get_valid_rooms
    sector_id_sum = 0
    fileObj = File.new('input.txt', "r")
    valid_rooms = 0
    while (room = fileObj.gets)
        sector_id_sum = sector_id_sum + validate_room(room).to_i
    end
    fileObj.close
    puts sector_id_sum
end

# from http://stackoverflow.com/questions/31489800/rotating-letters-in-a-string-so-that-each-letter-is-shifted-to-another-letter-by
def shift(str, n)
  abc = ("a".."z").to_a.join
  abc_rot = abc.chars.rotate(n).join
  str.tr(abc, abc_rot)
end

def translate_room(room)
    match = room.match(/(.*)-(\d*)\[(.*)\]/)
    line_name = match[1]
    sector_id = match[2]
    return shift(line_name, sector_id.to_i) + " has ID " + sector_id
end

def translate_rooms
    fileObj = File.new('input.txt', "r")
    while (room = fileObj.gets)
        puts translate_room(room)
    end
    fileObj.close
end

translate_rooms