En löydä pit-raporttia.. Tällainen generoitui.



cd C:\Users\Olaml\OneDrive\Asiakirjat\NetBeansProjects\Minesweeper; "JAVA_HOME=C:\\Program Files\\Java\\jdk1.8.0_65" cmd /c "\"\"C:\\Program Files\\tmcbeans\\java\\maven\\bin\\mvn.bat\" -Dmaven.ext.class.path=C:\\Users\\Olaml\\AppData\\Roaming\\.tmcbeans\\dev\\maven-nblib\\netbeans-eventspy.jar -Dfile.encoding=UTF-8 org.pitest:pitest-maven:mutationCoverage\""
Scanning for projects...
                                                                        
------------------------------------------------------------------------
Building Minesweeper 1.0-SNAPSHOT
------------------------------------------------------------------------

--- pitest-maven:1.1.8:mutationCoverage (default-cli) @ Minesweeper ---
Found plugin : Default csv report plugin
Found plugin : Default xml report plugin
Found plugin : Default html report plugin
Found plugin : Default limit mutations plugin
Found shared classpath plugin : Default mutation engine
Adding org.pitest:pitest to SUT classpath
Mutating from C:\Users\Olaml\OneDrive\Asiakirjat\NetBeansProjects\Minesweeper\target\classes
17:13:28 PIT >> INFO : Verbose logging is disabled. If you encounter an problem please enable it before reporting an issue.
17:13:28 PIT >> INFO : Sending 0 test classes to minion
17:13:28 PIT >> INFO : Sent tests to minion
17:13:28 PIT >> INFO : Calculated coverage in 0 seconds.
17:13:28 PIT >> INFO : Created  1 mutation test units
/17:13:28 PIT >> INFO : Completed in 0 seconds
================================================================================
- Timings
================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : < 1 second
--------------------------------------------------------------------------------
> Total  : < 1 second
--------------------------------------------------------------------------------
================================================================================
- Statistics
================================================================================
>> Generated 4 mutations Killed 0 (0%)
>> Ran 0 tests (0 tests per mutation)
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 1 Killed 0 (0%)
> KILLED 0 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
>> Generated 1 Killed 0 (0%)
> KILLED 0 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
>> Generated 1 Killed 0 (0%)
> KILLED 0 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 1 Killed 0 (0%)
> KILLED 0 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 2.191s
Finished at: Fri Feb 05 17:13:29 EET 2016
Final Memory: 12M/155M