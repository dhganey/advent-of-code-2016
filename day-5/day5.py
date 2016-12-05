import hashlib

def find_password(input):
    index = 0
    password = ""
    while len(password) < 8:
        hash = hashlib.md5(input + str(index)).hexdigest()
        if hash[:5] == '00000':
            password = password + "" + hash[5]
            print password
        index = index + 1
    return password

def find_password_advanced(input):
    index = 0
    password = ['','','','','','','','']
    while '' in password:
        hash = hashlib.md5(input + str(index)).hexdigest()
        if hash[:5] == '00000':
            if hash[5].isdigit() and int(hash[5]) < 8 and not password[int(hash[5])]:
                password[int(hash[5])] = hash[6]
            print password
        index = index + 1
    return password

print find_password_advanced("reyedfim")