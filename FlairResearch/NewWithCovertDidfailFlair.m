Covert = xlsread('ResultOfCovertNew.xlsx','Covert50','I6:BF10');
Flair = xlsread('ResultOfCovertNew.xlsx','Flair50','I6:BF10');
Didfail = xlsread('ResultOfCovertNew.xlsx','Didfail50','I6:BF10');
itemNo = 150;
%init Matrix
datap = zeros(5,itemNo);
for  n=1:5
    for i=1:50
        %        Covert 1,4,7...
        datap(n,(i-1)*3+1) = Covert(n,i);
        %        Flair 3,6,9...
        datap(n,(i-1)*3+3) = Flair(n,i);
        if i<31
           %        Didfail 2,5,8...
            datap(n,(i-1)*3+2) = Didfail(n,i);
        else
            datap(n,(i-1)*3+2) = -105;
        end
        
        
    end
end
g = zeros(1,itemNo);
pos = zeros(1,itemNo);
for  n1=1:itemNo
    g(n1) = n1;
    if mod(n1,3) == 1
%        Covert 1,4,7...
         pos(n1) = (n1-1)/3 + 1;
    elseif mod(n1,3) == 2
%        Didfail 2,5,8...
        pos(n1) = (n1-2)/3+1 +0.25;
    else
        %        Flair 3,6,9...
        pos(n1) =n1/3 + 0.5;
    end
end

%boxplot(datap,g,'positions',pos);

 boxplot(datap,g,'positions',pos,'whisker',5,'Widths',0.26);
 % 
 
 ax = gca;
 ax.FontSize = 19;
 
 ylim([-100 4200]);
 yt = get(gca,'YTick');
%set(gca,'YTickLabel', sprintf('%.4f',yt))
  xlabel('Bundle Size(#Apps)','FontSize',32);
  
ylabel('AnalysisTime (Seconds)','FontSize',32);


  xAxisPos = zeros(1,itemNo/3);
  for n2 = 1:(itemNo/3) 
      y = n2*3-2;
      z = y+2;
      xAxisPos(n2) = mean(pos(y:z));
  end
 set(gca, 'xtick', xAxisPos);


 
  grey =  [0.5, 0.5, 0.5];
  white = [1,1,1];
 dark =  [0.1, 0.1, 0.1];
 lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', 'k');

%  Change Box Color
  h = findobj(gca,'Tag','Box');
   for j=1:length(h)
       x = mod(j,3);
       if x == 1
           boxcolor = dark;
       elseif x==2
           boxcolor = grey;
       else
           %Covert
           boxcolor = white;
       end    
     patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.5);
   end
  
  % Add Legend
     c = get(gca, 'Children');
   %  hleg1 = legend('\color{red} sin(x)','\color{blue} cos(x)');
     hleg1 = legend(c(1:3),'COVERT','DIDFAIL','FLAIR');

    
   set(hleg1,'FontSize',25) 
  

