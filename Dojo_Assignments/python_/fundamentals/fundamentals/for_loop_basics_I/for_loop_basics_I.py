'''
Print all numbers from 1-150
'''
for x in range(151):
    print(x)
'''
print all the multiples of 5 from 5-1000
'''
for x in range(5, 1001, 5):
    print(x)
'''
Print integers 1 to 100. If divisible by 5,
print "Coding" instead. If divisible by 10,
print "Coding Dojo"
'''
for x in range(0, 101):
    if x % 10 == 0:
        print("Coding Dojo")
    elif x % 5 == 0:
        print("Coding")
    else:
        print(x)
sum = 0
'''
Adds the odds from 0 - 500,000
'''
for x in range(0, 500000):
    if x % 2 != 0:
        sum += x
print(sum)
'''
Print positive numbers starting at 2018, counting down by fours.
'''
for x in range(2018,0, -4):
    print(x)
'''
Set three variables: lowNum, highNum, mult. Starting at lowNum and going through highNum, print only the integers that are a multiple of mult. For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)
'''
lowNum = 2
highNum = 9
mult = 3
for x in range(lowNum, highNum+1):
    if x % mult == 0:
        print(x)