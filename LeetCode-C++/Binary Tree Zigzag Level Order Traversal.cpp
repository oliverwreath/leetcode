#define F(i, a, b) for(int i = a; i <= b; i++)
#define FB(i, a, b) for(int i = a; i >= b; i--)
#define MAX2(a, b) a>b?a:b
#define MIN2(a, b) a<b?a:b

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    //typedef 
    typedef TreeNode* iterator;

    //methods
    void helper( queue<iterator>& que, int len, bool toRight, vector<vector<int>>& ret ){
        int tmp = 0;
        vector<int> row;

        while( len > 0 ){
            if( toRight ){
                row.emplace( row.end(), (*que.front()).val );
            }
            else{
                row.emplace( row.begin(), (*que.front()).val );
            }
            iterator left = ( (*que.front()).left );
            iterator right = ( (*que.front()).right );
            que.pop();

            if( left != NULL ){
                que.push( left );
                tmp++;
            }
            if( right != NULL ){
                que.push( right );
                tmp++;
            }
            len--;
        }

        ret.emplace( ret.end(), row);
        if( tmp > 0 ){
            helper( que, tmp, !toRight, ret );
        }
    }

    vector<vector<int> > zigzagLevelOrder(iterator root){
        if( root == NULL ){
            return vector<vector<int>>();
        }

        queue<iterator> que;
        vector<vector<int>> ret = vector<vector<int>>();
        que.push(root);
        helper( que, 1, true, ret );

        return ret;
    }
};
