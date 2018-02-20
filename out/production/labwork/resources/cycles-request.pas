i:=1;
while i<5 do begin
  writeln(i,'. Привіт!');
  i:=i+1
end;

s:=3;
for i:=1 to s*s do begin
  s:=5;
  writeln(i)
end;

a:=0;
while a<100 do begin
  a:=a+1;
  write(a,' ');
  if a<20 then continue;
  writeln('не менше 20');
  if a=30 then break;
end;