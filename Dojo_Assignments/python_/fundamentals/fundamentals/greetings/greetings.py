#Part I
#Write a program that asks for a users name, and greets them with their name
print("--------------Part I--------------")
personName = input('What is your name? ')
print(f"Greetings {personName}!")

#Part II
#If the name given is the same as your name, say "Hey, that's my name too!"
print("--------------Part II--------------")
if personName == "Ian":
    print("Hey, that's my name too!")

#Part III
#Ask for 10 names and keep a record of them.  After 10 names are given, say 'It was nice to meet all of you'.
print("--------------Part III--------------")
names = []
for x in range(10):
    names.append(input("What is your name? "))
    
print("It was nice to meet all of you")
print("Names are:")
for x in range(len(names)):
    print(names[x])

#Part IV - NINJA Level
#Ask for 10 names again.  This time check to see if the name was already given.  If it hasn't greet them other wise ask for a new name.  At the end of the program, you should have greeted 10 unique names.
print("--------------Part IV--------------")
names = []
x = 0
while x < 10:
    name = (input("What is your name? "))
    if name in names:
        print("name already given")
    else :
        names.append(name)
        x+=1
print("It was nice to meet all of you")
print("Names are:")
for x in range(len(names)):
    print(names[x])
