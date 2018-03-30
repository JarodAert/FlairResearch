X = xlsread('Flair Reseach Results.xlsx','Total Averages','A5:A54');
CovertAverage=xlsread('Flair Reseach Results.xlsx','Total Averages','B5:B54');
FlairAverage=xlsread('Flair Reseach Results.xlsx','Total Averages','D5:D54');
SEALANTAverage=xlsread('Flair Reseach Results.xlsx','Total Averages','E5:E54');
DIALDroidAverage=xlsread('Flair Reseach Results.xlsx','Total Averages','F5:F54');
DidfailAverage=xlsread('Flair Reseach Results.xlsx','Total Averages','C5:C34');

black=[0,0,0];
darkgrey=[0.25,0.25,0.25];
grey=[0.5,0.5,0.5];
lightgrey=[0.75,0.75,0.75];

plot(X,CovertAverage,'Color',black);
hold on
plot(X,FlairAverage,'Color',darkgrey);
hold on
plot(X,SEALANTAverage,'Color',grey);
hold on
plot(X,DIALDroidAverage,'--','Color',darkgrey);
hold on
plot(DidfailAverage,'-.','Color',grey);
hold off

legend({'Covert','Flair','SEALANT','DIALDroid','Didfail'},'Location','northwest','FontSize',14);

%Set labels
xlabel('Bundle Size(#Apps)','FontSize',24);
ylabel('AnalysisTime (Seconds)','FontSize',24);

xlim([1,50]);
ylim([-100,2500]);