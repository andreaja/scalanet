# Generated by Buildr 1.3.2, change to your liking
# Scala-tools Maven2 Repository
repositories.remote << 'http://scala-tools.org/repo-releases'
repositories.remote << 'http://www.ibiblio.org/maven2/'


desc 'scalanet'
define 'scalanet' do
  project.group = 'com.mycompany.app'
  project.version = '1.0-SNAPSHOT'
  compile.with 'org.scala-lang:scala-library:jar:2.7.1'
  package :jar, :id => 'scalanet'
end