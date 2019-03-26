window.onload = function () {
    var s = Snap(8000, 6000);
    var triangle;
    Snap.load("triangle.svg", function (f) {
        g = f.select("g");
        //s.append(g);
        //g.drag();

        for(i=0; ++i < 50;){
            triangle = g.clone();
            s.append(triangle);
            triangle.drag();
            triangle.transform("s0.25");            

        }

        for(i=0; ++i < 50;){
            triangle = g.clone();
            s.append(triangle);
            triangle.transform("r180s0.25");
            //namespaces in css selectors didnt work too well, such as: inkscape:label
            triangle.select("[label=iris]").attr({fill:"#bada55"});
            triangle.drag();

        }

        
        
    });



}
