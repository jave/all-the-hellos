var Year = function (year) {
    this.theyear=year;

};

isDivisable = function (x,y) {
    return x % y == 0;
};

Year.prototype.isLeap = function () {
    return isDivisable(this.theyear, 4) && ! (isDivisable(this.theyear, 100)) || isDivisable(this.theyear, 400);
};

module.exports = Year;

