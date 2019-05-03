const GIGASECOND_IN_MILLIS = 1e9 * 1e3;


// export is needed so the tests can find the fn
export function gigasecond(dateOfBirth) {
    const birthTime = dateOfBirth.getTime();
    return new Date(birthTime + GIGASECOND_IN_MILLIS);
    
};

// this is a lambda style declaration

// export const gigasecond = (dateOfBirth) => {
//   const birthTime = dateOfBirth.getTime();
//   return new Date(birthTime + GIGASECOND_IN_MILLIS);
// };
