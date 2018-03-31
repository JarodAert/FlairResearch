addpath('applyhatch_plusC');
addpath('applyhatch_pluscolor');
% Create original plot
fH = gcf; colormap(jet(4));
h = bar(rand(3, 4));
legend('Apple', 'Orange', 'Banana', 'Melon', 'Location', 'EastOutside');

% Apply Brandon's function
tH = title('Brandon''s applyhatch');
applyhatch_pluscolor(fH, '\-x.', 0, [1 0 1 0], jet(4));

% Apply Brian's function
set(tH, 'String', 'Brian''s applyhatch');
applyhatch_plusC(fH, '\-x.', 'kkkk');

set(tH, 'String', 'Original');