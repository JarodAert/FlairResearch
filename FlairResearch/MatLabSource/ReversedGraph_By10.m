Covert = xlsread('Flair Reseach Results-Full.xlsx','Covert','R60:V65');
Flair = xlsread('Flair Reseach Results-Full.xlsx','Flair','R59:V64');
Didfail = xlsread('Flair Reseach Results-Full.xlsx','Didfail','P39:T44');
SEALANT = xlsread('Flair Reseach Results-Full.xlsx','SEALANT','R64:V69');
DIALDroid = xlsread('Flair Reseach Results-Full.xlsx','DIALDroid','AB59:AF64');
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
        DidfailData(n,i)=Didfail(i,n);
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

 DialDroidPlot=boxplot(DialDroidData,'positions',posDialDroid,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
 hold on
 CovertBoxPlot=boxplot(CovertData,'positions',posCovert,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
 hold on
 FlairBoxPlot=boxplot(FlairData,'positions',posFlair,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
 hold on
 DidfailBoxPlot=boxplot(DidfailData,'positions',posDidfail,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
 hold on
 SEALANTBoxPlot=boxplot(SEALANTData,'positions',posSEALANT,'whisker',5,'Widths',0.1,'Colors',[0 0 0]);
hold off
 
 
 light =  [0.75, 0.75, 0.75];
  grey=[0.5,0.5,0.5];
  dark=[0.25,0.25,0.25];
  white = [1,1,1];
 black =  [0, 0, 0];

 
 h = findobj(gcf,'Tag','Box');
 disp(size(h));
   for j=1:length(h)
       if j<7
           %DIALDroid
           boxcolor = white;
           
       elseif j>6 && j<13
           %SEALANT
           boxcolor = white;
       elseif j>12 && j<19
           %Flair
           boxcolor = black;
           
       elseif j>18 && j<25
           %Covert
           boxcolor = light;
       else
           %DIALDroid
           boxcolor = dark;
       end    
     p=patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.8);
     uistack(p,'bottom');
   end
 
    j=zeros(5,1);
   j(1)=patch(NaN,NaN,NaN,white);
   j(2)=patch(NaN,NaN,NaN,white);
   j(3)=patch(NaN,NaN,NaN,dark);
   j(4)=patch(NaN,NaN,NaN,light);
   j(5)=patch(NaN,NaN,NaN,black);
   
    c = get(gca, 'Children');
   hleg1 = legend(j,{'Didfail','SEALANT','DIALDroid', 'Covert','Flair'},'Location','NorthEast');
   set(hleg1,'FontSize',32) 
   
   set(gca,'xtick',1:6);
    set(gca,'xticklabel',{'50','40','30','20','10','1'});
    xlim([0.5,6.5]);
    
    %Set labels
xlab=xlabel('Bundle Size(#Apps)','FontSize',32);
ylab=ylabel('AnalysisTime (Seconds)','FontSize',32);

   
    ylim([-100,2500]);
    xt=get(gca,'XTick');
    set(gca,'FontSize',16);
    
 lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', black, 'LineWidth', 1.5);
 for j=1:length(lines)
     uistack(lines(j),'top');
 end
 