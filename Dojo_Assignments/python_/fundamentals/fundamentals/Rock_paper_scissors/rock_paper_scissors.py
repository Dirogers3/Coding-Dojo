import random

cpu_points = 0
user_points = 0

print("Select 1 for Rock")
print("Select 2 for Paper")
print("Select 3 for Scissors")

choices = {
    "rock" : "1",
    "paper" : "2",
    "scissors" : "3"
}
for x in range (5):
    if cpu_points == 3:
        break
    if user_points == 3: 
        break
    computer_choice = random.randint(1,3)
    user_choice = int(choices[input("What is your decision? ")])
    if (user_choice == computer_choice):
        print("Draw")
        continue
    if ((user_choice == 1 and  computer_choice == 3) or (user_choice == 2 and computer_choice == 1) or (user_choice == 3 and computer_choice ==2)):
        print("Victory")
        user_points += 1
    else:
        print("Defeat")
        cpu_points += 1   
if cpu_points == user_points:
    print("It was a tie!")
elif user_points == 3:
    print("You are the Winner!")
else:
    print("Sorry! You lost! Try again.")
