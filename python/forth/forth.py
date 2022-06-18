import re

class StackUnderflowError(Exception):
    pass

# notes about this solution
# - i didnt want to define a class, but i still wound up with some global state, the "defined" vars
# - many python list operations are "destructive" which stumped me several times, im more used to lisp
# - the semantics of this toy forth seemed confusing to me, and are different from a real forth


STATE_NORMAL=0
STATE_DEFINING=1
defined={}

def evaluate(input_data):
    stack=[]
    global defined
    defined={}
    try:
        for string_data in input_data:
            tokens = string_data.split()
            tokens.reverse()
            evaluate_list(stack, tokens)
        return stack
    except IndexError:
        raise StackUnderflowError("Insufficient number of items in stack")
    except ZeroDivisionError:
        raise ZeroDivisionError("divide by zero")
    except:
        print(stack)
        print(defined)
        raise

def evaluate_list(stack, tokens):
    state=STATE_NORMAL
    tokens=tokens.copy()
    while True:
        token = tokens.pop()
        if token==":":
            state=STATE_DEFINING
            defining_name=tokens.pop().lower()
            #defined[defining_name]=[]
            defining_list=[]
            if re.match("-?[0-9]+", defining_name):
                raise ValueError("illegal operation")
            
        elif state==STATE_NORMAL:
            evaluate_item(stack, token)
        elif state==STATE_DEFINING:
            if token==";":
                defined[defining_name]=defining_list
                state=STATE_NORMAL
            else:
                if token in defined:
                    print("already defined {token} using prev def {prevdef}"
                          .format( token=token, prevdef=defined[token][0]))
                    defining_list.insert(0,defined[token][0])
                else:
                    defining_list.insert(0,token)
        if len(tokens) == 0:
            break
    return stack


def evaluate_item(stack, input_item):
    input_item=input_item.lower()
    if re.match("-?[0-9]+", input_item):
        stack.append(int(input_item))
    elif input_item in defined:
        evaluate_list(stack, defined[input_item])
    elif re.match("dup", input_item):
        top=stack.pop()
        stack.append(top)
        stack.append(top)
    elif re.match("swap", input_item):
        top1=stack.pop()
        top2=stack.pop()        
        stack.append(top1)
        stack.append(top2)
    elif re.match("over", input_item):
        if len(stack)-2 < 0:
            raise StackUnderflowError("Insufficient number of items in stack")
        over=stack[len(stack)-2]
        stack.append(over)
    elif re.match("drop", input_item):
        top=stack.pop()
    elif re.match("[*+-/]", input_item):
        if len(stack)<=1:
            raise StackUnderflowError("Insufficient number of items in stack")
        b = stack.pop()
        a = stack.pop()
        op = input_item
        result = eval("{a} {op} {b}".format(a=a,b=b,op=op))
        stack.append(int(result))
    else:
        raise ValueError("undefined operation")
