/*
A huge phone book containing pairs of the form {phone number, person's name} was stored as a vector sorted by name in alphabetical order.
Write a program that finds the phone number of a given person in this list, bearing in mind that the list is very large and that users
need the search results to be as fast as possible.
------------------------------------------------------------------------------------------
*/

const phoneBook = [
    {
        phone: 341232133,
        name: 'Antonio'
    },
    {
        phone: 692812131,
        name: 'Benz'
    },
    {
        phone: 381203912,
        name: 'Carl'
    },
    {
        phone: 381202933,
        name: 'Daryl'
    }
];




const getPhoneNumberByContactName = (phoneBookList, name) => {
    let startIndex  = 0;
    let stopIndex   = phoneBookList.length - 1;
    let mainIndex      = Math.floor((stopIndex + startIndex) / 2);

    while(phoneBookList[mainIndex].name != name && startIndex < stopIndex){
        if (name > phoneBookList[mainIndex].name){
            startIndex = mainIndex + 1;
        } else if (name < phoneBookList[mainIndex].name){
            stopIndex = mainIndex - 1;
        }

        mainIndex = Math.floor((stopIndex + startIndex)/2);
    }

    const phoneBookIndex = (phoneBookList[mainIndex].name != name) ? -1 : mainIndex;
    const phoneNumber = phoneBookIndex === -1 ? -1 : phoneBookList[mainIndex].phone;

    return  phoneNumber;
}
