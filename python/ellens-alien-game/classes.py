# TODO: Create a class called "Alien" here


def new_aliens_collection(positions):
    """Function taking a list of position tuples, creating one Alien instance per position.

    :param positions: list - A list of tuples of (x, y) coordinates.
    :return: list - A list of Alien objects.
    """

    return [Alien(x, y) for (x, y) in positions]

class Alien:
    # x_coordinate=0
    # y_coordinate=0
    # health=3
    total_aliens_created=0
    def __init__(self,xarg,yarg):
        self.x_coordinate=xarg
        self.y_coordinate=yarg
        self.health=3
        Alien.total_aliens_created=Alien.total_aliens_created+1
    def hit(self):
        self.health=self.health-1
    def is_alive(self):
        if self.health<=0:
            return
        else:
            return True
    def teleport(self,xarg,yarg):
        self.x_coordinate=xarg
        self.y_coordinate=yarg
    def collision_detection(self, other_object):
        pass
    
    
