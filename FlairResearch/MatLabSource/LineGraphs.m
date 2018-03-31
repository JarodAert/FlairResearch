Covert = xlsread('ResultOfCovertNew.xlsx','Covert50','I6:BF10');
X=5;

Y=zeros(50,5);

for  n=1:5
    for i=1:50
        Y(i,n)=Covert(n,i);
    end
end

plot(Y);
