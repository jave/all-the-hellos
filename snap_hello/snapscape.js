window.onload = function () {
    //make the house dragable
    //its called a "box" as a profound statement on the human condition in western society
    var box = Snap.select("#box");
    box.drag();

    //the sun, including its warm rays
    var sun =  Snap.select("#sun");
    //just the sun
    var suncircle =   Snap.select("#suncircle");
    //and the moon
    var moon =  Snap.select("#moon");
    //the sky
    var sky =  Snap.select("#myrect");

    //animate the sun a bit as we hover it
    var sunrot = 0;
    function sunhover(){
        console.log("hover " + sun.attr("transform")  );
        suncircle.animate({fill:"lightyellow"},500);
        //sun.animate({transform:"t"+0+","+0+"r"+sunrot+""},5000 );
        sun.animate({transform:"...R"+sunrot+""},500 );
        sunrot+=10;
    }

    function sununhover(){
        console.log("unhover"  );
        this.select("#suncircle").animate({fill:"yellow"},500);

    }

    sun.hover(sunhover,sununhover);


    var sunmoveFunc = function (dx, dy, posx, posy) {
        console.log(dx + " " + dy + " " + posx + " " + posy + "s");

        this.attr( { transform : "t" + [posx,posy] } ); // basic drag, you would want to adjust to take care of where you grab etc.
        this.lasty=posy;
    };

          
    sun.drag( sunmoveFunc,
              function(){
                  console.log("Move started");
              },
              function(x,y){
                  console.log("Move stopped "+this.lasty);
                  if(this.lasty<100)
                      newcolor="lightblue"; //sun is high in the sky
                  else   if(this.lasty<400) //sun is rising
                      newcolor="blue";
                  else  //sun is low
                      newcolor="black";
                  sky.animate(
                                 {
                                     fill : newcolor
                                         },
                                 500);//, mina.backin);
                          
                
              });
    moon.drag(); 
              // moveFunc,

              // function(){
              //     console.log("Move started");
              // },
              // function(x,y){
              //     console.log("Move stopped "+this.lasty);
                
              // });

};
