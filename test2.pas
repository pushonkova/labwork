program Project2;
 
unit Unit1;

interface
uses
     Windows,Graphics, Controls, Dialogs;
type
     TForm1 = class( TForm );

var R,Rt,A : Real;
begin
ReadLn( R ); //radius
Write('Vvedite A ='); //square side
ReadLn( A );
Rt:=sqrt(2)/2*A;
if Rt <= R then WriteLn('Ok')
ReadLn;
end. //42
