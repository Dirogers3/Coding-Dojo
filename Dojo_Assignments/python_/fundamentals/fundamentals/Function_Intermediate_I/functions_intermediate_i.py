x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0] = 15
print(x) 
students[0]["last_name"] = "Bryant"
print(students)
sports_directory["soccer"][0] = "Andres"
print(sports_directory)
z[0]['y'] = 30
print(z)

students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(a):
    for x in range(len(students)):
        print(f"first_name - {students[x]['first_name']}, last_name - {students[x]['last_name']}")
iterateDictionary(students) 

def iterateDictionary2(keyword,some_list):
    for x in range(len(students)):
        a = some_list[x][keyword]
        print(a)
iterateDictionary2('first_name', students)
iterateDictionary2('last_name', students)

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(x):
    count = len(dojo['locations'])
    instructors_count = len(dojo['instructors'])
    print(count , "LOCATIONS")
    for i in range(1):
        for j in range(len(dojo['locations'])):
            print(dojo['locations'][j])
    print("\n")
    print(instructors_count, "INSTRUCTORS")
    for i in range(1):
        for j in range(len(dojo['instructors'])):
            print(dojo['instructors'][j])
printInfo(dojo)
# output:
# 7 LOCATIONS
# San Jose
# Seattle
# Dallas
# Chicago
# Tulsa
# DC
# Burbank
    
# 8 INSTRUCTORS
# Michael
# Amy
# Eduardo
# Josh
# Graham
# Patrick
# Minh
# Devon

# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
# first_name - Michael, last_name - Jordan
# first_name - John, last_name - Rosales
# first_name - Mark, last_name - Guillen
# first_name - KB, last_name - Tonel