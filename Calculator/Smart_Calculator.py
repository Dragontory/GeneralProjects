
# main python proghram
response=['Welcome to Smart Calculator!','My name is JOSE!',
          'Thanks for using me ;) ','Sorry, this is  beyond my ability :(']
 
# fetching tokens from the text command
def extract_from_text(text):
    l=[]
    for t in text.split(' '):
        try:
            l.append(float(t))
        except ValueError:
            pass
    return l
 
# calculating LCM
def lcm(a,b):
    L=a if a>b else b
    while L<=a*b:
        if L%a==0 and L%b==0:
            return L
        L+=1
 
# calculating HCF
def hcf(a,b):
    H=a if a<b else b
    while H>=1:
        if a%H==0 and b%H==0:
            return H
        H-=1

# Addition
def add(a,b):
    return a+b
 
# Subtraction
def sub(a,b):
    return a-b
 
# Multiplication
def mul(a,b):
    return a*b
 
# Division
def div(a,b):
    return a/b
 
# Remainder
def mod(a,b):
    return a%b

# Exponent
def exp(a,b):
    return a**b
 
# Response to command
# printing - "Thanks for using me ;)" on exit
def end():
    print(response[2])
    input('press enter key to exit')
    exit()
  
def myname():
    print(response[1])
def sorry():
    print(response[3])

# Operations - performed on the basis of text tokens
operations={'ADD':add,'PLUS':add,'SUM':add,'ADDITION':add,'+':add,
            'SUB':sub,'SUBTRACT':sub, 'MINUS':sub,'DIFFERENCE':sub,'-':sub,
            'LCM':lcm,'MULTIPLE':lcm,
            'HCF':hcf,'GCD':hcf,'FACTOR':hcf,'DIVISOR':hcf,
            'PRODUCT':mul, 'MULTIPLY':mul,'MULTIPLICATION':mul, 'TIMES':mul, '*':mul, 'X':mul,
            'DIVISION':div,'DIVIDE':div, 'DIVIDED':div,'/':div,
            'MOD':mod,'REMAINDER':mod,'MODULAS':mod,'%':mod,
            '^':exp,'POWER':exp,'SQUARE':exp,'SQUARED':exp,'CUBE':exp,'CUBED':exp}
 
# commands
commands={'NAME':myname,'WHO':myname,'EXIT':end,'END':end,'CLOSE':end}
          
print('--------------'+response[0]+'------------')
print('--------------'+response[1]+'--------------------')
  
while True:
    print()
    text=input('Enter What Ya Need:  ')
    for word in text.split(' '):
        if word.upper() in operations.keys():
            try:
                l = extract_from_text(text)
                r = operations[word.upper()] (l[0],l[1])
                print(r)
            except:
                print('Error, Please enter again!!')
            finally:
                      break
        elif word.upper() in commands.keys():
                      commands[word.upper()]()
                      break
    else:        
        sorry()

