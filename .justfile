default:
    @just --list

# verify
verify:
    mvn clean verify

# overwrite the existing expected test outputs for some major update
overwrite:
    mvn clean verify -DshouldOverwriteExpectedContents=true

# generate antlr stuff and compile project
antlr:
    mvn clean antlr4:antlr4 compile

