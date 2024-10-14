print("~~~mini calculator ~~~")
num1 = float(input("enter first number is: "))
num2 = float(input("enter scond number is: "))
print("enter 1 for addition \n enter 2 for substraction \n enter 3 for multiplication \n enter 4 for division \n")
choice = int(input("enter the number 1-4"))
if choice == 1:
    print("the addition of given two number",num1+num2)
elif choice == 2:
    print("the substraction of given two number",num1-num2)
elif choice == 3:
    print("the muliplication of given two number",num1*num2)
elif choice == 4:
    print("the division of given two number",num1/num2)
else:
    print("invalide number")