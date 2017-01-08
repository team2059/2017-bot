#!/bin/zsh
# For support:
# https://austenwares.com/gogs/stonewareslord/autoformat/src/java
#
# Format all java files
GLOB=( **/*.java )
# Astyle options:
# --mode=java    : java formatting
# -xc            : Brace attached to class names
# --style=google : google style (similar to 1tbs)
# -j             : Always add brackets (even on one line if statements)
# -s2            : Three spaces
# -xG            : Indent modifiers
# -xe            : Erase blank lines
# -S             : Indent switches
# -K             : Indent cases
# -N             : Indent namespaces
# -xn            : Attach bracket to namespace
# -xl            : Attach inlines
# -n             : Don't make a backup
# -p             : Pad operators
# -H             : Pad header (space after if, for, while)
OPTS=( --mode=java -xc --style=google -j -s2 -xG -xe -S -K -N -xn -xl -n -p -H )
# Colorize output if you can
if which colout>/dev/null; then
  astyle $OPTS $GLOB|\grep -P '^(?!Unchanged)'|colout '(Formatted)' green||true
else
  astyle $OPTS $GLOB|\grep -P '^(?!Unchanged)'||true
fi
