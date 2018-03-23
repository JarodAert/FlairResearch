%Read Data in
Flair = xlsread('FlairResults.xlsx','SEALANT','K5:O54');
itemNo=50;
%Transfer data into an array
datap = zeros(5,itemNo);
for  n=1:5
    for i=1:50
        %        Covert 1,4,7...
        datap(n,i) = Flair(i,n);        
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
 boxplot(datap,g,'positions',pos,'whisker',5,'Widths',0.26,'Color',[0.25,0.25,0.25]);
 
 %Give some buffer on each side
 xlim([0,51]);
 
%Set labels
xlabel('Bundle Size(#Apps)','FontSize',26);
ylabel('AnalysisTime (Seconds)','FontSize',26);
title('SEALANT Analysis','FontSize',32);

%Set Y limits
ylim([-100 2500]);
yt = get(gca,'YTick');

%Gets the plots
lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', 'k');
%  Change Box Color
  h = findobj(gca,'Tag','Box');
   for j=1:length(h)
       x = mod(j,3);
           boxcolor = [0.25,0.25,0.25];    
     patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.5);
   end
