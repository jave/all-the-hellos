% Please visit https://exercism.io/tracks/prolog/installation
% for instructions on setting up prolog.
% Visit https://exercism.io/tracks/prolog/tests
% for help running the tests for prolog exercises.

% Replace the goal below with
% your implementation.

%hello_world(false).

hello_world('Hello World!').

hello_world(Person, Greeting) :-
    format(atom(Greeting), 'Hello ~w!', [Person]).


