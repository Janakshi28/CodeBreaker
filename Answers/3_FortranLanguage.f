!We at 99X Technology are interested in looking at how well you can adapt into any programming language.

!Your task to solve the below problem using the Fortran language. (Please note that you cannot use any other language for this problem)

!Given an array of integers, your task is print whether the number is odd or even.

!Input Format

!The first line contains an integer N, denoting the size of the array. 
!The second line contains N space-separated integers representing the array's elements.

Constraints

!0 < N < 10000

!Output Format

!Print whether the number is odd or even

!Sample Input 0

!6
!2 3 8 9 10 12
!Sample Output 0

!Even Odd Even Odd Even Even

program EvenOROdd
    
    !variable declaration
    integer(kind=16), allocatable,dimension(:):: numbers
    integer  :: n,i
    
    read(*,*) n
    
    !array allocates specified memory 
    allocate(numbers(n)) 
    
    
    if(n>0 .and. (n<10000)) then
    
        !Reading integers to the allocated array from user in one line
        read(*,*) (numbers(i),i=1,n)
               
        !Checking whether the numbers of the array are odd or even
        do i=1,n
            
                if(mod(numbers(i),2)== 0) then                  
                    write(*,"(A)", advance="no") "Even "  !Writing output on the same line
                else                
                    write(*,"(A)", advance="no") "Odd "   !Writing output on the same line
                end if
            
        end do
        
    end if    
    
    
end program EvenOROdd                                