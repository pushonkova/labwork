unit Main;

interface

uses
  Windows, Messages;

type
  TForm1 = class(TForm)
    Edit1: TEdit;
    
    procedure Button14Click(Sender: TObject);
  private
    { Private declarations }
    end;

var
  Form1: TForm1;

implementation

{$R *.DFM}

procedure TForm1.Button5Click(Sender: TObject);
var
  UnlimitedInteger:TUnlimitedInteger;
begin
  UnlimitedInteger:=TUnlimitedInteger.Create;
  try
    UnlimitedInteger.HexStr:=Edit1.Text;
    Edit3.Text:=UnlimitedInteger.HexStr;
  finally
    UnlimitedInteger.Free;
  end;
end;


      UnlimitedFloat1.Surplus:=a;
      UnlimitedFloat2.Surplus:=a;
      UnlimitedFloat1.FractionAsHex:=Edit6.Text;
      UnlimitedFloat2.FractionAsHex:=Edit7.Text;
      UnlimitedFloat1.Exponent:=StrToInt(Edit9.Text)+a;
      UnlimitedFloat2.Exponent:=StrToInt(Edit10.Text)+a;
      UnlimitedFloat1.Plus(UnlimitedFloat2);
      Edit8.Text:=UnlimitedFloat1.FractionAsHex;
      Edit11.Text:=IntToStr(UnlimitedFloat1.Exponent-a);}
    finally
      UnlimitedFloat2.Free;
    end;
  finally
    UnlimitedFloat1.Free;
  end;
end;

procedure TForm1.Button8Click(Sender: TObject);
var
  UnlimitedFloat1,UnlimitedFloat2:TUnlimitedFloat;
  a:int64;
begin
  UnlimitedFloat1:=TUnlimitedFloat.Create;
  try
    UnlimitedFloat2:=TUnlimitedFloat.Create;
    try
{      UnlimitedFloat1.ExponentLen:=2;
      UnlimitedFloat2.ExponentLen:=2;
      Edit8.Text:=UnlimitedFloat1.FractionAsHex;
      Edit11.Text:=IntToStr(UnlimitedFloat1.Exponent-a); }
    finally
      UnlimitedFloat2.Free;
    end;
  
//    UnlimitedFloat1.FractionLen:=11;
    a:=10000;//($100000000 shr 1)-1;
    UnlimitedFloat1.Surplus:=a;
    UnlimitedFloat1.FractionDecStr:=Edit6.Text;
    Edit7.Text:=UnlimitedFloat1.FractionAsHex;
    Edit8.Text:=UnlimitedFloat1.FractionDecStr;
  //  Edit8.Text:=UnlimitedFloat1.GetRoundDecStr(Edit8.Text,50); }
  finally
    UnlimitedFloat1.Free;
  end;
end;


end.
