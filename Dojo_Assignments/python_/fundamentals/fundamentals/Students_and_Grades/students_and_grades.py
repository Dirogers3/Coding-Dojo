students = []
dictionary = {
    1:'Math',
    2:'Science',
    3:'History'
}
while True:
    numStudents = input("How many students do you have: ")
    try:
        numStudents = int(numStudents)
    except:
        continue
    if numStudents < 1:
        continue
    break
for i in range(numStudents):
    while True:
        name = input("Student Name: ")
        try:
            name = str(name)
        except:
            continue
        if name == "":
            continue
        break
    while True:
        grade = input("Student Grade: ")
        try:
            grade = int(grade)
        except:
            continue
        if grade < 0 or grade > 100:
            continue
        break
    while True:
        course = input("Select a course 1-Math, 2-Science, 3-History: ")
        try:
            course = int(course)
        except:
            continue
        if course < 0 or course > 3:
            continue
        break
    students.append({'Name':name, 'Grade':int(grade), 'Course':int(course)}) 
for x in range(numStudents):
    print(f"Name: {students[x]['Name']}, Grade: {students[x]['Grade']}, Course: {dictionary[students[x]['Course']]}")
