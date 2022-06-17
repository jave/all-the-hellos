# Globals for the directions
# Change the values as you see fit
NORTH = 0
EAST =  1
SOUTH = 2
WEST =  3


class Robot:
    def __init__(self, direction=NORTH, x_pos=0, y_pos=0):
        self.direction = direction
        self.coordinates = (x_pos, y_pos)

    def move_step(self, step):
        if step == "R":
            self.direction = (self.direction + 1) % 4
        elif step == "L":
            self.direction = (self.direction - 1) % 4
        elif step == "A":
            if self.direction == EAST:
                self.coordinates = (self.coordinates[0]+1, self.coordinates[1])
            elif self.direction == NORTH:
                self.coordinates = (self.coordinates[0], self.coordinates[1]+1)
            elif self.direction == WEST:
                self.coordinates = (self.coordinates[0]-1, self.coordinates[1])
            elif self.direction == SOUTH:
                self.coordinates = (self.coordinates[0], self.coordinates[1]-1)

    def move(self, steps):
        for step in steps:
            self.move_step(step)
