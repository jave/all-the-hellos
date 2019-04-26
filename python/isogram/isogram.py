
# python list comprehensions
# [expression(i) for i in old_list if filter(i)]
# so this gives a list of only the chars, to lower, in input.
#[c.lower() for c in "ASASDGKNAFG333" if c.isalpha()] = ['a', 's', 'a', 's', 'd', 'g', 'k', 'n', 'a', 'f', 'g']
def is_isogram(maybe_isogram):
   cleaned_maybe_isogram = [c.lower() for c in maybe_isogram if c.isalpha()]
   # okay, so now i want to convert the cleaned_maybe_isogram to a set.
   # it the set contains as many chars as the original maybe_isogram, then it is an isogram!
   cleaned_maybe_isogram_set_length = len(set(cleaned_maybe_isogram))
   maybe_isogram_length=len(cleaned_maybe_isogram)
   return  cleaned_maybe_isogram_set_length == maybe_isogram_length

# one could do the whole thing as a oneliner, but IMHO python
# list comprehensions are not very readable
