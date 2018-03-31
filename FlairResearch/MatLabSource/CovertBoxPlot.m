%Read Data in
Covert = xlsread('Flair Reseach Results.xlsx','DIALDroid','AB17:AF27');
Flair = xlsread('Flair Reseach Results.xlsx','Flair','R17:V27');
itemNo=11;
%Transfer data into an array
datap = zeros(5,itemNo);
datap1 = zeros(5,itemNo);
for  n=1:5
    for i=1:itemNo
        %        Covert 1,4,7...
        
        datap(n,i) = Covert(i,n); 
        
        datap1(n,i) = Flair(i,n);
    end
end

%Get the x axis positions and put them into the array
g = zeros(1,itemNo);
pos = zeros(1,itemNo);
for  n1=1:itemNo
    g(n1) = n1;
%        Covert 1,4,7...
         pos(n1) = n1;
end

%Plot the data into the box plot
 boxplot(datap,g,'positions',pos,'whisker',5,'Widths',0.26,'Color',[0,0,0]);
 hold on
 boxplot(datap1,g,'positions',pos-0.275,'whisker',5,'Widths',0.26,'Color',[0,0,0]);
 hold off
 
 %Give some buffer on each side
 xlim([0,11.5]);
 set(gca,'xtick',1:11);
 set(gca,'xticklabel',{'1','5','10','15','20','25','30','35','40','45','50'});
 
%Set labels
xlabel('Bundle Size(#Apps)','FontSize',26);
ylabel('AnalysisTime (Seconds)','FontSize',26);
%title('Covert Analysis','FontSize',32);

%Set Y limits
ylim([-100 2500]);
yt = get(gca,'YTick');

FlairColor=[0,0,0];
OtherColor=[0.25,0.25,0.25];

%Gets the plots
lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', 'k');
%  Change Box Color
  h = findobj(gca,'Tag','Box');
   for j=1:length(h)
        if j>11
           boxcolor = OtherColor; 
           patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.5);
        else
           boxcolor = FlairColor;
           patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.75);
        end
     
   end

xt=get(gca,'XTick');
set(gca,'FontSize',16);

j=zeros(2,1);
j(1)=patch(NaN,NaN,NaN,OtherColor+0.25);
j(2)=patch(NaN,NaN,NaN,FlairColor);

 c = get(gca, 'Children');
 hleg1 = legend(j,{'DIALDroid','Flair'},'Location','NorthWest');
 set(hleg1,'FontSize',25) 
