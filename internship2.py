import random
#while true
print ("~~~~~~~welcome to RPS~~~~~~~")
user_score = 0
computer_score = 0
ties = 0
name = input("enter your name here: ")
print("""
wining rules:
1. paper vs rock--->paper
2. rock vs scissors--->rock
3. scissors vs paper--->scissors""")
print ()
#while true:
print("""choices are: 
1. rock
2. paper
3. scissors""")
choice = int(input("enter your choice from 1-3: "))
print()
while choice >3 or choice <1:
    choice = int(input("enter valid input"))

if choice == 1:
    user_choice = "rock"
elif choice == 2:
    user_choice = "paper"
else:
    user_choice = "scissors"
    print ("the user's choice is ", user_choice)
    print ("now it is computer's turn")
    
    computr = random.randint(1,3)
if  computer == 1:
    comp_choice = "rpck"
elif computer == 2:
    comp_choice = "paper"
else:
    comp_choice = "scissors"


print("the computer's choice is",comp_choice)
    
if ((user_choice == "paper" and comp_choice == "rock") or (user_choice == "rock" and comp_choice =="paper")):
    print ("paper wins")
    result = "paper"
elif ((user_choice == "scissors" and comp_choice == "rock") or (user_choice == "rock" and comp_choice =="scissors")):
     print("rock wins")
    result = "rock"
elif (user_choice == comp_choice):
     print ("it's a tie")
     result ="tie"
else:
    print ("scissors wins")
    result = "scissors"

