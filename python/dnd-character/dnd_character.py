import random
import math

# it was a little difficult understanding the specs for this imho,
# even though i played a lot of DnD back in the days

class Character:
    def __init__(self):
        '''Construct the character'''
        self.strength = self.ability()
        self.dexterity = self.ability()
        self.constitution = self.ability()
        self.intelligence = self.ability()
        self.wisdom = self.ability()
        self.charisma = self.ability()
        #HP is a function of constitution
        self.hitpoints = 10 + modifier(self.constitution)        
        

    def ability(self):
        '''roll dice according to rules'''
        # get 4 rolls using a list comprehension. since we dont need the item use _ rather than a variable
        # sort, throw away the 1st item because its smalles. sum and return
        return sum(sorted([random.randint(1,6) for _ in range(4) ])[1:])
        
    
def modifier(val):
    '''You find your character's constitution modifier by subtracting 10
from your character's constitution, divide by 2 and round down.'''
    # floor rounds down
    return math.floor((val-10)/2)
