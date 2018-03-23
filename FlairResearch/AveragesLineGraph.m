X = xlsread('FlairResults.xlsx','Total Averages','A5:A54');
CovertAverage=xlsread('FlairResults.xlsx','Total Averages','B5:B54');
FlairAverage=xlsread('FlairResults.xlsx','Total Averages','D5:D54');
SEALANTAverage=xlsread('FlairResults.xlsx','Total Averages','E5:E54');
DIALDroidAverage=xlsread('FlairResults.xlsx','Total Averages','F5:F54');

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
hold off

legend({'Covert','Flair','SEALANT','DIALDroid'},'Location','northwest','FontSize',18);

%Set labels
xlabel('Bundle Size(#Apps)','FontSize',26);
ylabel('AnalysisTime (Seconds)','FontSize',26);
title('Average Analysis Time','FontSize',32);

xlim([1,50]);
ylim([0,2000]);