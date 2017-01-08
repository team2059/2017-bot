#!/bin/zsh
# For support:
# https://austenwares.com/gogs/stonewareslord/autoformat
#
GLOB=( src/**/*.java )
OPTS=( -H -K -N -S -j -n -p -s2 -xG -xc -xe -xl -xn -z2 --mode=java )
astyle $OPTS $GLOB|\grep -P '^(?!Unchanged)'||true
