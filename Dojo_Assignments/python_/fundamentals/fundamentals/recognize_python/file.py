num1 = 42 #variable declaration number
num2 = 2.3 #variable declaration number
boolean = True #variable declaration boolean
string = 'Hello World' #variable declaration string
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] # variable declaration, initialized 5 strings
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} #variable declaration dictionary, initialed
fruit = ('blueberry', 'strawberry', 'banana') # declare variable of tuple with 3 strings initialized
print(type(fruit)) # display  tuple of fruits
print(pizza_toppings[1]) #display the second string from pizza_topping list
pizza_toppings.append('Mushrooms') #add string to pizza_topping list
print(person['name'])#display name of the person dictionary
person['name'] = 'George' # changes value of the name of the person to George
person['eye_color'] = 'blue'# change value of the eye_color in the person dictionary
print(fruit[2]) # print the 3 fruit of the fruit tuple

if num1 > 45: #if else statement
    print("It's greater") # print string true
else:
    print("It's lower") #print other struing if false

if len(string) < 5:# if elif else statement if length of string is less than 5
    print("It's a short word!") #if true print string
elif len(string) > 15: #if length  is longer than 15
    print("It's a long word!") #print string
else:#if nothing is true than print the line below
    print("Just right!")

for x in range(5): #for loop init x till 5
    print(x) #print value of x
for x in range(2,5): #for loop from 2 to 5 but not including 5
    print(x)    #print value of x
for x in range(2,10,3): # for loop  start from 2 end at 10 increment at 3
    print(x) #print all values of x
x = 0 #sets x  to 0
while(x < 5):   # while loop, as long as x is under 5 perform the line below
    print(x) # print value of x
    x += 1 #increment x by 1

pizza_toppings.pop() #use the pop method to take out the last item in the list
pizza_toppings.pop(1) #use the pop method to take out the 2 item in teh list

print(person) #print the person
person.pop('eye_color') #remove the value that is stored in the eye_color dictionary
print(person) #print the new version of the person

for topping in pizza_toppings: #for loop  in pizza_toppings that goes through each variable in the dictoinary
    if topping == 'Pepperoni': #if statment also
        continue # if true it will continue to next line
    print('After 1st if statement') #Print statement
    if topping == 'Olives': # if topping from pizza_topping list equals olives than it will break on the next line.
        break

def print_hello_ten_times(): # defining a function
    for num in range(10): # for loop from 0 - 9
        print('Hello')

print_hello_ten_times() #function call prints hellow 10 times

def print_hello_x_times(x): #defineing a function that takes a parameter 
    for num in range(x):#for loop from 0 to x
        print('Hello')

print_hello_x_times(4) #function call prints hellow 4 times

def print_hello_x_or_ten_times(x = 10): # defines a function that takes an argument x = 10
    for num in range(x): #for loop from 0
        print('Hello')

print_hello_x_or_ten_times() #prints hellow 10 times
print_hello_x_or_ten_times(4) #prints hello 4 times


"""
Bonus section
"""

print(num3) #NameError: name <variable name> is not defined
num3 = 72 # initializing a variable
fruit[0] = 'cranberry' # TypeError: 'tuple' object does not support item assignment
print(person['favorite_team']) #KeyError: 'favorite_team'
print(pizza_toppings[7]) #IndexError: list index out of range
  print(boolean) #IndentationError: unexpected indent
fruit.append('raspberry') #AttributeError: 'tuple' object has no attribute 'append'
fruit.pop(1) #AttributeError: 'tuple' object has no attribute 'pop'