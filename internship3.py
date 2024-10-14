import random
import string

def generate_password(length):
    # Define the characters to use in the password
    characters = string.ascii_letters + string.digits + string.punctuation
    
    # Generate a random password
    password = ''.join(random.choice(characters) for _ in range(length))
    
    return password

def main():
    # Prompt the user to enter the desired password length
    try:
        length = int(input("Enter the desired password length: "))
        
        if length < 4:
            print("Password length should be at least 4 characters for better security.")
        else:
            # Generate and display the password
            password = generate_password(length)
            print(f"Generated Password: {password}")
    except ValueError:
        print("Please enter a valid number.")

if __name__ == "__main__":
    main()
