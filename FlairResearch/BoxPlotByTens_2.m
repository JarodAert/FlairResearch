Covert = xlsread('Flair Reseach Results.xlsx','Covert','R5:V10');
Flair = xlsread('Flair Reseach Results.xlsx','Flair','R5:V10');
Didfail = xlsread('Flair Reseach Results.xlsx','Didfail','P5:T8');
SEALANT = xlsread('Flair Reseach Results.xlsx','SEALANT','R5:V10');
DIALDroid = xlsread('Flair Reseach Results.xlsx','DIALDroid','AB5:AF10');
itemNo = 6;

DialDroidData=zeros(5,itemNo);
CovertData=zeros(5,itemNo);
SEALANTData=zeros(5,itemNo);
FlairData=zeros(5,itemNo);
DidfailData=zeros(5,itemNo);

for  n=1:5
    for i=1:6
        DialDroidData(n,i)=DIALDroid(i,n);
        CovertData(n,i)=Covert(i,n);
        FlairData(n,i)=Flair(i,n);
        SEALANTData(n,i)=SEALANT(i,n);
        if i<5
         DidfailData(n,i)=Didfail(i,n);
        else
         DidfailData(n,i)=-105;
        end
    end
end

g=zeros(1,itemNo);
posDialDroid = zeros(1,itemNo);
posCovert = zeros(1,itemNo);
posFlair = zeros(1,itemNo);
posDidfail = zeros(1,itemNo);
posSEALANT = zeros(1,itemNo);
for i=1:itemNo
    g(i)=i;
    posDialDroid(i) = i+0.2;
    posCovert(i) = i+0.1;
    posFlair(i) = i-0.1;
    posDidfail(i) = i-0.2;
    posSEALANT(i) = i;
end
disp(size(posDialDroid));
 DialDroidPlot=boxplot(DialDroidData,'positions',posDialDroid,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
 hold on
 CovertBoxPlot=boxplot(CovertData,'positions',posCovert,'whisker',5,'Widths',0.1);
 hold on
 FlairBoxPlot=boxplot(FlairData,'positions',posFlair,'whisker',5,'Widths',0.1);
 hold on
 DidfailBoxPlot=boxplot(DidfailData,'positions',posDidfail,'whisker',5,'Widths',0.1);
 hold on
 SEALANTBoxPlot=boxplot(SEALANTData,'positions',posSEALANT,'whisker',5,'Widths',0.1);
hold off
 
 
 light =  [0.75, 0.75, 0.75];
  grey=[0.5,0.5,0.5];
  dark=[0.25,0.25,0.25];
  white = [1,1,1];
 black =  [0, 0, 0];
 lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', black, 'LineWidth', 1);
 
 h = findobj(gcf,'Tag','Box');
 disp(size(h));
   for j=1:length(h)
       if j<7
           %DIALDroid
           boxcolor = white;
           
       elseif j>6 && j<13
           %SEALANT
           boxcolor = grey;
       elseif j>12 && j<19
           %Flair
           boxcolor = dark;
       elseif j>18 && j<25
           %Didfail
           boxcolor = black;
       else
           %Covert
           boxcolor = light;
       end    
     patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.9);
     if x==1
        %hatch(h(j),0.1,[0.1 0.1 0.1],'-',11,1);
     end
   end
   
    j=zeros(5,1);
   j(1)=patch(NaN,NaN,NaN,white);
   j(2)=patch(NaN,NaN,NaN,grey);
   j(3)=patch(NaN,NaN,NaN,dark);
   j(4)=patch(NaN,NaN,NaN,black);
   j(5)=patch(NaN,NaN,NaN,light);
   
    c = get(gca, 'Children');
   hleg1 = legend(j,{'SEALANT','Didfail','Flair', 'Covert','DialDroid'},'Location','NorthWest');
   set(hleg1,'FontSize',25) 
   
   set(gca,'xtick',1:6);
    set(gca,'xticklabel',{'1','10','20','30','40','50'});
    xlim([0.5,6.5]);
 