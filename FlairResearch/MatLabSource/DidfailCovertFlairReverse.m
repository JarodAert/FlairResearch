Covert = xlsread('Flair Reseach Results.xlsx','Covert','R5:V10');
Flair = xlsread('Flair Reseach Results.xlsx','Flair','R5:V10');
Didfail = xlsread('Flair Reseach Results.xlsx','Didfail','P5:T8');
%CovertReverse = xlsread('ResultOfCovertNew.xlsx','CovertReverse','I12:Q16');
%FlairReverse = xlsread('ResultOfCovertNew.xlsx','FlairReverse','I12:Q16');
%DidfailReverse = xlsread('ResultOfCovertNew.xlsx','DidfailReverse','I12:Q16');
itemNo = 27;
%init Matrix
datap = zeros(5,itemNo);
for  n=1:5
    for i=1:9
        %        Covert 1,4,7...
        datap(n,(i-1)*3+1) = CovertReverse(n,i);
        %        Flair 3,6,9...
        datap(n,(i-1)*3+3) = FlairReverse(n,i);
        if i>5
           %        Didfail 2,5,8...
            datap(n,(i-1)*3+2) = DidfailReverse(n,i);
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
         pos(n1) = (n1-1)/3 + 1;
    elseif mod(n1,3) == 2
        pos(n1) = (n1-2)/3+1 +0.25;
    else
        pos(n1) =n1/3 + 0.5;
    end
end

%boxplot(datap,g,'positions',pos);

 boxplot(datap,g,'positions',pos,'whisker',5,'Widths',0.26);
 % 
 
 ax = gca;
 ax.FontSize = 19;
 
 ylim([-100 2500]);
 yt = get(gca,'YTick');
%set(gca,'YTickLabel', sprintf('%.4f',yt))
  xlabel('Bundle Size(#Apps)','FontSize',32);
  
ylabel('AnalysisTime (Seconds)','FontSize',32);

xlabel('Bundle Size(#Apps)','FontSize',28);
ylabel('Analysis Time (Second)','FontSize',28);
 xticklabels({'45','40','35','30','25','20','15','10','5'})

  xAxisPos = zeros(1,itemNo/3);
  for n2 = 1:(itemNo/3) 
      y = n2*3-2;
      z = y+2;
      xAxisPos(n2) = mean(pos(y:z));
  end
 set(gca, 'xtick', xAxisPos);


 
  blue =  [0.5, 0.5, 0.5];
  white = [1,1,1];
 dark =  [0.1, 0.1, 0.1];
 lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', 'k');

%  Change Box Color
  h = findobj(gca,'Tag','Box');
   for j=1:length(h)
       x = mod(j,3);
       if x == 1
           %Flair
           boxcolor = dark;
       elseif x==2
           boxcolor = blue;
       else
           %Covert
           boxcolor = white;
       end    
     patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.5);
   end
  
  % Add Legend
     c = get(gca, 'Children');
     hleg1 = legend(c(1:3),'Covert','Didfail','Flair');
   set(hleg1,'FontSize',25) 
   
   % FH = gcf;
   %colormap(jet(4));
  %h = bar(rand(3, 4));
  % fH = gcf; colormap(jet(4));
% h = bar(rand(3, 4));
 %tH = title('Brandon''s applyhatch');
 % Apply Brian's function
 %set(tH, 'String', 'Brian''s applyhatch');
 %applyhatch_plusC(FH, '\-x.', 'rkbk');

%set(tH, 'String', 'Original');
  

