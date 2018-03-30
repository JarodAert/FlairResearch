%Read Data in
Covert = xlsread('Flair Reseach Results.xlsx','Covert','R17:V27');
itemNo=11;
%Transfer data into an array
datap = zeros(5,itemNo);
for  n=1:5
    for i=1:itemNo
        %        Covert 1,4,7...
        datap(n,i) = Covert(i,n);        
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
