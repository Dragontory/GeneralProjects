print("Select an operation to perform: ")
print("1. ADD")
print("2. SUBTRACT")
print("3. MULTIPLY")
print("4. DIVIDE")

operation = float(input())


if operation == 1:
    num1 = float(input("Enter your first number: "))
    num2 = float(input("Enter your second number: "))
    temp = (num1 + num2)
    print(str(num1) + " + " + str(num2) + " = " + str(temp))
elif operation == 2:
    num1 = float(input("Enter your first number: "))
    num2 = float(input("Enter your second number: "))
    temp = (num1 - num2)
    print(str(num1) + " - " + str(num2) + " = " + str(temp))
elif operation == 3:
    num1 = float(input("Enter your first number: "))
    num2 = float(input("Enter your second number: "))
    temp = (num1 * num2)
    print(str(num1) + " * " + str(num2) + " = " + str(temp))
elif operation == 4:
    num1 = float(input("Enter your first number: "))
    num2 = float(input("Enter your second number: "))
    temp = (num1 / num2)
    print(str(num1) + " / " + str(num2) + " = " + str(temp))
else: 
    print("Error. Invalid input")