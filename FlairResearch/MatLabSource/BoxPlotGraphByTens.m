Covert = xlsread('Flair Reseach Results.xlsx','Covert','R5:V10');
Flair = xlsread('Flair Reseach Results.xlsx','Flair','R5:V10');
Didfail = xlsread('Flair Reseach Results.xlsx','Didfail','P5:T8');
SEALANT = xlsread('Flair Reseach Results.xlsx','SEALANT','R5:V10');
DIALDroid = xlsread('Flair Reseach Results.xlsx','DIALDroid','AB5:AF10');
itemNo = 30;
%init Matrix
datap = zeros(5,itemNo);

for  n=1:5
    for i=1:6
        %        Covert 1,6,11...
        datap(n,(i-1)*5+1) = Covert(i,n);
        
        %        Flair 2,7,12...
        datap(n,(i-1)*5+2) = Flair(i,n);
        
        %       SEALANT 4,9,14
        datap(n,(i-1)*5+4) = SEALANT(i,n);
        %       DIALDroid 5,10,15
        datap(n,(i-1)*5+5) = DIALDroid(i,n);
        if i<5
           %        Didfail 3,8,13...
            datap(n,(i-1)*5+3) = Didfail(i,n);
        else
            datap(n,(i-1)*5+3) = -105;
        end
        
        
    end
end
g = zeros(1,itemNo);
pos = zeros(1,itemNo);
for  n1=1:itemNo
    g(n1) = n1;
    if mod(n1,5) == 1
%        Covert 1,4,7...
         pos(n1) = (n1-1)/5 + 1;
    elseif mod(n1,5) == 2
%        Didfail 2,5,8...
        pos(n1) = (n1-2)/5+1 +0.6;
    elseif mod(n1,5)==3
        %        Flair 3,6,9...
        pos(n1) =(n1-3)/5 + 0.7;
    elseif mod(n1,5)==4
        %       SEALANT 4,9,14
        pos(n1) =(n1-4)/5 + 0.8;
    else
        %       DIAlDroid 5,10,15
        pos(n1) =n1/5 + 0.9;
    end
end

%boxplot(datap,g,'positions',pos);

 boxplot(datap,g,'positions',pos,'whisker',5,'Widths',0.1);
 
 % 
 
 ax = gca;
 ax.FontSize = 19;
 
 ylim([-100 2500]);
 yt = get(gca,'YTick');
%set(gca,'YTickLabel', sprintf('%.4f',yt))
  xlabel('Bundle Size(#Apps)','FontSize',32);
  
ylabel('AnalysisTime (Seconds)','FontSize',32);


%   xAxisPos = zeros(1,itemNo/50);
%   for n2 = 1:(itemNo/50) 
%       y = n2*5-2;
%       z = y+2;
%       xAxisPos(n2) = n2*10; %mean(pos(y:z));
%   end
%  set(gca, 'xtick', xAxisPos);

set(gca,'xtick',1:6);
set(gca,'xticklabel',{'1','10','20','30','40','50'});
xlim([0,6.5]);
                


  light =  [0.75, 0.75, 0.75];
  grey=[0.5,0.5,0.5];
  dark=[0.25,0.25,0.25];
  white = [1,1,1];
 black =  [0, 0, 0];
 lines = findobj(gcf, 'type', 'line', 'Tag', 'Median');
 set(lines, 'Color', black);

%  Change Box Color
  h = findobj(gcf,'Tag','Box');
   for j=1:length(h)
       x = mod(j,5);
       if x == 1
           %DIALDroid
           boxcolor = white;
           
       elseif x==2
           %SEALANT
           boxcolor = grey;
       elseif x==3
           %Flair
           boxcolor = dark;
       elseif x==4
           %Didfail
           boxcolor = black;
       else
           %Covert
           boxcolor = light;
       end    
     patch(get(h(j),'XData'),get(h(j),'YData'),boxcolor,'FaceAlpha',.75);
     if x==1
        %hatch(h(j),0.1,[0.1 0.1 0.1],'-',11,1);
     end
   end
  
  % Add Legend
     c = get(gca, 'Children');
   
     hleg1 = legend({'DIALDroid','SEALANT','Flair', 'Didfail','Covert'},'Location','northwest');
 
   set(hleg1,'FontSize',25) 
   
    
