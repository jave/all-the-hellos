


EXPECTED_BAKE_TIME=40
PREPARATION_TIME=2


def bake_time_remaining(elapsed_bake_time):
    """Calculate the bake time remaining.

    :param elapsed_bake_time: int baking time already elapsed.
    :return: int remaining bake time derived from 'EXPECTED_BAKE_TIME'.

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    """

    return EXPECTED_BAKE_TIME-elapsed_bake_time



def preparation_time_in_minutes(layers):
    """Calculate the preparation_time_in_minutes.

    :param layers: int num layers
    :return: int how long to prepare the thing.

    """
    return PREPARATION_TIME*layers

def elapsed_time_in_minutes(layers, elapsed_bake_time):
    """Calculate the elapsed_time_in_minutes.

    :param layers: int num layers
    :param elapsed_bake_time: int num bake
    :return: int how long to bake the thing.

    """
    return preparation_time_in_minutes(layers)+elapsed_bake_time
